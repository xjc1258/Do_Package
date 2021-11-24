package basic.ObserverModel;

import java.util.EventListener;

public interface BellEventListener extends EventListener{
	//事件处理方法，听到铃声
    public void heardBell(RingEvent e);

}
