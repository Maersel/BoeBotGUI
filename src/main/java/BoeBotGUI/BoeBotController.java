package BoeBotGUI;

import jssc.SerialPort;
import jssc.SerialPortException;

public class BoeBotController {

    //    private locationRecorder locationRecorder;
    private boolean bluetoothStarted = false;


    public BoeBotController() {
//        this.locationRecorder = new locationRecorder();

//        this.serialPort= new SerialPort("COM7");
    }


    SerialPort serialPort = new SerialPort("COM11");

    public void startBluetooth() {
        if (!bluetoothStarted) {
            try {
                serialPort.openPort(); // Open the serial connection
                serialPort.setParams(SerialPort.BAUDRATE_115200,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);
                bluetoothStarted = true;
            } catch (SerialPortException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendRoute(int p1, int p2, int m) {
        try {
            serialPort.writeInt(p1);
            serialPort.writeInt(p2);
            serialPort.writeInt(m);
        } catch (SerialPortException e) {
            e.printStackTrace();
        }
    }
}
