module w05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.apache.pdfbox;
    requires google.genai;
    requires google.cloud.storage;
    exports ca.utoronto.utm.SuperGradeTracker to javafx.graphics;
}
