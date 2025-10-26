module w05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    opens ca.utoronto.utm.spaghettiClock to javafx.fxml;
    opens ca.utoronto.utm.nonMVCballoon to javafx.fxml;
    opens ca.utoronto.utm.balloonmvc to javafx.fxml;
    opens ca.utoronto.utm.numbersmvc to javafx.fxml;
    exports ca.utoronto.utm.spaghettiClock;
    exports ca.utoronto.utm.nonMVCballoon;
    exports ca.utoronto.utm.balloonmvc;
    exports ca.utoronto.utm.numbersmvc;
    exports ca.utoronto.utm.SuperGradeTracker to javafx.graphics;
}
