byte[] sharedSecret = CryptoUtils.generateSharedSecret(clientKeyPair.getPrivate(), serverPublicKey);
            
boolean isVerified = CryptoUtils.verifySignature(serverPublicKey, "Server Authentication", signature);
        if (!isVerified) {
            System.out.println("Server verification failed. Exiting...");
            return;
            }

String hmac = in.readLine();
String expectedHmac = CryptoUtils.generateHMAC("Server Authentication", sharedSecret);
        if (!hmac.equals(expectedHmac)) {
            System.out.println("HMAC verification failed. Exiting...");
            return;
            }
