package googlechartwrapper.style;

import googlechartwrapper.util.IFeatureAppender;

import java.awt.Color;
import java.util.List;

/**
 * Specifies a RangeMarker <a href="http://code.google.com/apis/chart/#hor_line_marker"> http://code.google.com/apis/chart/#hor_line_marker#map</a> 
 * 
 * @author steffan
 *
 */
public class RangeMarker implements IFeatureAppender {
	
	private Color color;
	private float startPoint;
	private float endPoint;
	private Alignment align;
	
	/**
	 * Constructs the horizontal range marker
	 * 
	 * @param align 
	 * @param color color of range
	 * @param startPoint value between 0.0 and 1.0
	 * @param endPoint value between 0.0 and 1.0
	 * @throws IllegalArgumentException if startPoint or endPoint out of range
	 */
	public RangeMarker(Alignment align, Color color, float startPoint,float endPoint){
		
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		if(startPoint < 0.0f || startPoint > 1.0f)
			throw new IllegalArgumentException("startPoint out of range");
		if(endPoint < 0.0f || endPoint > 1.0f)
			throw new IllegalArgumentException("endPoint out of range");		
		
		this.color = color;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.align = align;
		
	}
	/**
	 * 
	 * @param color the color of the range
	 * 
	 * @throws IllegalArgumentException if color <code>null</code>
	 */ 
	public void setColor(Color color){
		if(color == null)
			throw new IllegalArgumentException("color can not be null");
		this.color = color;
	}
	/**
	 * 
	 * @param startPoint value between 0.0 and 1.0
	 * @param endPoint value between 0.0 and 1.0
	 * @throws IllegalArgumentException if startPoint or endPoint out of range
	 */
	public void setRange(int startPoint, int endPoint){
		
		if(startPoint < 0.0f || startPoint > 1.0f)
			throw new IllegalArgumentException("startPoint out of range");
		if(endPoint < 0.0f || endPoint > 1.0f)
			throw new IllegalArgumentException("endPoint out of range");
		
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		
	}
	/**
	 * 
	 * @return the color of the range
	 */
	public Color getColor(){
		
		return this.color;
	}
	/**
	 * 
	 * @return
	 */
	public float getStartPoint(){
		return this.startPoint;
	}
	/**
	 * 
	 * @return
	 */
	public float getStopPoint(){
		return this.endPoint;
	}
	
	public String getAppendableString(List<? extends IFeatureAppender> otherAppenders) {
		
		StringBuilder builder = new StringBuilder();
		
		if(this.align == Alignment.Horizontal){
			builder.append("r,");
		}
		else{
			builder.append("R,");
		}
		//append color
		if(this.color != null){
		builder.append(Integer.toHexString(color.getRGB()).substring(2,8));
		}
		// default is white
		else{
			builder.append("ffffff");
		}
		//append non use value
		builder.append(",0");
		//startpoint
		builder.append(',');
		builder.append(this.startPoint);
		//endpoint
		builder.append(',');
		builder.append(this.endPoint);
		
		return builder.toString();
	}
	/**
	 * 
	 * @author steffan
	 *
	 */
	public enum Alignment{
		
		Horizontal,
		
		Vertical
	}
	
}
