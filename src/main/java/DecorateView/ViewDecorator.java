package DecorateView;

public abstract class ViewDecorator implements InterfaceView{
	protected InterfaceView decoratedView;
	
	public ViewDecorator(InterfaceView decoratedView){
		this.decoratedView = decoratedView;
	}
	
}
