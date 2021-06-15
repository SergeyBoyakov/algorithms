package com.sb.concurrency.educative.h2o_machine;

public class H2OMachineThread extends Thread {
    H2OMachine h2OMachine;
    String atom;

    public H2OMachineThread(final H2OMachine h2OMachine, final String atom) {
        this.h2OMachine = h2OMachine;
        this.atom = atom;
    }

    public void run() {
        if ("H".equalsIgnoreCase(atom)) {
            try {
                h2OMachine.hydrogenAtom();
            } catch (Exception e) {
                // noop
            }
        } else if ("O".equalsIgnoreCase(atom)) {
            try {
                h2OMachine.oxygenAtom();
            } catch (Exception e) {
                // noop
            }
        }
    }
}
