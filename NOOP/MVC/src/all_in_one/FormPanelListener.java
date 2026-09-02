package all_in_one;

import model_pckg.Programmer;

import java.util.EventListener;

public interface FormPanelListener extends EventListener {

    void formEventOccurred(Programmer programmer);
}
