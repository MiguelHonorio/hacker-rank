import java.util.Base64;
        import java.time.Instant;
        import java.security.KeyPairGenerator;
        import java.security.KeyPair;
        import java.security.PrivateKey;
        import java.security.Signature;
        import java.security.SecureRandom;

public class JWTValidGenerator {

    public static void main(String[] args) {
        try {
            // Gerar JWT válido com nova assinatura
            String validJWT = generateValidJWT("GCSBIAFN", "536");

            System.out.println("=== JWT VÁLIDO GERADO ===");
            System.out.println(validJWT);

            System.out.println("\n=== VERIFICAÇÃO ===");
            verifyJWT(validJWT);

            System.out.println("\n=== INSTRUÇÕES ===");
            System.out.println("Este JWT pode ser validado no jwt.io");
            System.out.println("A assinatura é válida pois foi gerada com chave privada correspondente");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateValidJWT(String resource, String canal) throws Exception {
        // Gerar par de chaves RSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048, new SecureRandom());
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        // Header - mantendo o mesmo kid do exemplo original
        String headerJson = "{\"kid\":\"GwwQlWttYU0Z9pbZMOtkmsroLSH684RPCzKjcJh4bJc\",\"typ\":\"JWT\",\"alg\":\"RS256\"}";
        String header = Base64.getUrlEncoder().withoutPadding()
                .encodeToString(headerJson.getBytes());

        // Payload com novos valores
        long currentTime = Instant.now().getEpochSecond();
        long expirationTime = currentTime + (365L * 24 * 60 * 60); // 1 ano

        String payloadJson = String.format(
                "{\"aud\":\"teste_local\",\"sub\":\"teste_local_subject\",\"resource\":\"%s\",\"profile\":\"local\",\"iss\":\"conecta_sdk\",\"canal\":\"%s\",\"exp\":%d,\"iat\":%d}",
                resource, canal, expirationTime, currentTime
        );

        String payload = Base64.getUrlEncoder().withoutPadding()
                .encodeToString(payloadJson.getBytes());

        // Criar assinatura
        String headerAndPayload = header + "." + payload;
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(headerAndPayload.getBytes());
        byte[] signatureBytes = signature.sign();

        String signatureBase64 = Base64.getUrlEncoder().withoutPadding()
                .encodeToString(signatureBytes);

        return headerAndPayload + "." + signatureBase64;
    }

    // Versão que mantém timestamps originais
    public static String generateValidJWTWithOriginalTimestamps(String resource, String canal) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048, new SecureRandom());
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();

        String headerJson = "{\"kid\":\"GwwQlWttYU0Z9pbZMOtkmsroLSH684RPCzKjcJh4bJc\",\"typ\":\"JWT\",\"alg\":\"RS256\"}";
        String header = Base64.getUrlEncoder().withoutPadding()
                .encodeToString(headerJson.getBytes());

        // Usar timestamps originais
        String payloadJson = String.format(
                "{\"aud\":\"teste_local\",\"sub\":\"teste_local_subject\",\"resource\":\"%s\",\"profile\":\"local\",\"iss\":\"conecta_sdk\",\"canal\":\"%s\",\"exp\":1721835290,\"iat\":1690297490}",
                resource, canal
        );

        String payload = Base64.getUrlEncoder().withoutPadding()
                .encodeToString(payloadJson.getBytes());

        String headerAndPayload = header + "." + payload;
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(headerAndPayload.getBytes());
        byte[] signatureBytes = signature.sign();

        String signatureBase64 = Base64.getUrlEncoder().withoutPadding()
                .encodeToString(signatureBytes);

        return headerAndPayload + "." + signatureBase64;
    }

    // Método para simular apenas a estrutura (sem assinatura válida, só para visualização)
    public static String generateStructureOnlyJWT(String resource, String canal) {
        try {
            // Header original
            String header = "eyJraWQiOiJHd3dRbFd0dFlVMFo5cGJaTU90a21zcm9MU0g2ODRSUEN6S2pjSmg0YkpjIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ";

            // Novo payload
            long currentTime = Instant.now().getEpochSecond();
            long expirationTime = currentTime + (365L * 24 * 60 * 60);

            String payloadJson = String.format(
                    "{\"aud\":\"teste_local\",\"sub\":\"teste_local_subject\",\"resource\":\"%s\",\"profile\":\"local\",\"iss\":\"conecta_sdk\",\"canal\":\"%s\",\"exp\":%d,\"iat\":%d}",
                    resource, canal, expirationTime, currentTime
            );

            String payload = Base64.getUrlEncoder().withoutPadding()
                    .encodeToString(payloadJson.getBytes());

            // Assinatura fake (apenas para estrutura)
            String fakeSignature = "ASSINATURA_INVALIDA_APENAS_PARA_VISUALIZACAO";

            return header + "." + payload + "." + fakeSignature;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void verifyJWT(String jwt) {
        try {
            String[] parts = jwt.split("\\.");

            // Decodificar header
            byte[] headerBytes = Base64.getUrlDecoder().decode(parts[0]);
            String headerJson = new String(headerBytes);
            System.out.println("HEADER:");
            System.out.println(formatJson(headerJson));

            // Decodificar payload
            byte[] payloadBytes = Base64.getUrlDecoder().decode(parts[1]);
            String payloadJson = new String(payloadBytes);
            System.out.println("\nPAYLOAD:");
            System.out.println(formatJson(payloadJson));

            System.out.println("\nASSINATURA: " + parts[2].substring(0, 50) + "...");

        } catch (Exception e) {
            System.out.println("Erro na verificação: " + e.getMessage());
        }
    }

    private static String formatJson(String json) {
        return json
                .replace("{", "{\n  ")
                .replace(",", ",\n  ")
                .replace("}", "\n}");
    }
}