package aggroforce.render.camera;

import aggroforce.util.Side;

public class BlockTarget {

	public int x,y,z,id;
	public Side side;

	public BlockTarget(int x, int y, int z, int id){
		this.x = x;
		this.y = y;
		this.z = z;
		this.id = id;
	}

	public int getId(){
		return id;
	}
	public int[] getPos(){
		return new int[] {x,y,z};
	}
	@Override
	public String toString(){
		return "Pos-x:"+x+" y:"+y+" z:"+z+" ID-"+id;
	}
}
