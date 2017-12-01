import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    private static final int SIZE = 20;
    private static int velocity = 0;
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        PlayField world = (PlayField)getWorld();
        if( world.getStarted() == true )
        {
            checkCollision();
            move(velocity);
        }
    }
    
    public Ball()
    {
        GreenfootImage ballImage = new GreenfootImage( SIZE, SIZE );
        ballImage.setColor(Color.WHITE);
        ballImage.fillOval( 0, 0, SIZE, SIZE );
        setImage( ballImage );
        turn(Greenfoot.getRandomNumber (360) - 0 );
    }
    
    private void checkCollision()
    {
        Paddle hitting = (Paddle)getOneIntersectingObject(Paddle.class);
        PlayField world = (PlayField)getWorld();
        Score getPoint;
        if( hitting != null )
        {
            velocity = -velocity;
            setRotation( -getRotation() );
            move(velocity);
        }
        
        if( getY() <=10 )
        {
            setRotation(-getRotation() );
        }
        else if( getY() >= 590 )
        {
            setRotation(-getRotation() );
        }      
        
        if( getX() <=10 )
        {   
            getPoint = (Score) getWorld().getObjects(Score.class).get(1);
            getPoint.countScore();
            world.reset();
        }
        else if ( getX() >= 790 )
        {
            getPoint = (Score) getWorld().getObjects(Score.class).get(0);
            getPoint.countScore();
            world.reset();
        }
        
    }
    
    public void setVelocity( int v ) 
    {
        velocity = v;
    }

}