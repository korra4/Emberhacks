package ca.utoronto.utm.SuperGradeTracker;

import com.google.cloud.storage.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class PdfUploader {

    private static final String BUCKET_NAME = "my-public-bucket"; // must exist already

    public static String uploadPdf(Path pdfPath) throws Exception {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        String objectName = pdfPath.getFileName().toString();

        BlobId blobId = BlobId.of(BUCKET_NAME, objectName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType("application/pdf")
                .build();

        byte[] bytes = Files.readAllBytes(pdfPath);
        Blob blob = storage.create(blobInfo, bytes);

        // Make it public
        storage.createAcl(blobId, Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER));

        // Return the public HTTPS URL
        return String.format("https://storage.googleapis.com/%s/%s", BUCKET_NAME, objectName);
    }
}