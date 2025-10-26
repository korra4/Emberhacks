module w05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.apache.pdfbox;
    requires google.cloud.storage;
    requires com.google.genai;
    exports ca.utoronto.utm.SuperGradeTracker to javafx.graphics;
}
