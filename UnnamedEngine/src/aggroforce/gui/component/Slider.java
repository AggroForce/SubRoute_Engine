package aggroforce.gui.component;

import org.lwjgl.opengl.GL11;

import aggroforce.event.EventRegistry;
import aggroforce.gui.GUIComponent;
import aggroforce.gui.event.ComponentClicked;
import aggroforce.gui.event.GUIEvent;
import aggroforce.gui.event.SliderEvent;

public class Slider extends GUIComponent {

	private double sval,eval,val;
	private boolean vert;
	public Slider(GUIComponent parent,int xoffset, int yoffset, int width, int height, boolean vertical, double startval, double minval, double maxval) {
		super(parent, xoffset, yoffset, width, height);
		vert = vertical;
		sval = minval;
		eval = maxval;
		val = startval;

	}

	@Override
	public void onEvent(GUIEvent e) {
		if(e instanceof ComponentClicked){
		ComponentClicked evt = (ComponentClicked)e;
			if(this.isWithinComponent(evt.x, evt.y)||!evt.states[0]){
				if(evt.states[0]){
					if(vert){
						this.val = (((evt.y-this.y)/this.height)*(eval-sval))+sval;
					}else{
						this.val = (((evt.x-this.x)/this.width)*(eval-sval))+sval;
					}
					EventRegistry.EVENT_BUS.postEvent(new SliderEvent(this));
				}
			}
		}
	}

	public double getValue(){
		return val;
	}
	public double getMaxVal(){
		return eval;
	}
	public double getMinVal(){
		return sval;
	}

	@Override
	public void renderBackground(){
		GL11.glColor4f(0.8f, 0.8f, 1f, 0.8f);
		this.drawRect(x, y, width, height);
		GL11.glColor4f(1f, 1f, 1f, 1f);
		if(vert){
			this.drawRect(x, (int)(y+(val-sval)), width, 2);
		}else{
			this.drawRect((int)(x+(val-sval)), y, 2, height);

		}
	}
}
