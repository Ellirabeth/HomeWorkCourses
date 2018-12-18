package by.psoft.hospital.hospiatal;

import by.psoft.hospital.family.interfaces.IFamily;

public class MaternityHospital {

    private static MaternityHospital instance = null;

    private Reception reception;

    private DeliveryRoom deliveryRoom;

    private MaternityHospital(){
        reception = new Reception();
        deliveryRoom = new DeliveryRoom();
    }

    public static MaternityHospital getInstance() {
        if (instance == null) {
            instance = new MaternityHospital();
        }
        return instance;
    }

    public void acceptFamily(IFamily family) {
        reception.acceptFamily(family);
        deliveryRoom.addObserver(family.getHusband());
    }

    public void takeDelivery() {
        while (reception.hasNext()){
            IFamily family = reception.getNext();
            deliveryRoom.takeDelivery(family);
        }
    }
}
