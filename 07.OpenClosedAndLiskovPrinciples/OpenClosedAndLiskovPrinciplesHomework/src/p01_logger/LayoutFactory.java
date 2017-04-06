package p01_logger;

import p01_logger.interfaces.Layout;
import p01_logger.models.SimpleLayout;
import p01_logger.models.XmlLayout;

public class LayoutFactory {
    public static Layout createLayout(String type) {
        Layout layout = null;
        switch (type) {
            case "SimpleLayout":
                layout = new SimpleLayout();
                break;
            case "XmlLayout":
                layout = new XmlLayout();
                break;
        }

        return layout;
    }
}
