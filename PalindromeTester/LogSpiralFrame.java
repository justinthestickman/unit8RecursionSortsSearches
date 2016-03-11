import javax.swing.JFrame;

public class LogSpiralFrame extends JFrame
{
    private LogSpiralPanel panel;
    
    public LogSpiralFrame()
    {
        this.panel = new LogSpiralPanel();
        this.setTitle("Fibonacci Spiral");
        //this.setSize(this.panel.getWidth(), this.panel.getHeight());
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        LogSpiralFrame scene = new LogSpiralFrame();
    }
}