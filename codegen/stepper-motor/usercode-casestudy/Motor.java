package usercode;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import org.osate.runtime.Output;

public class Motor {
	private static boolean initialized = false;
	private static  WheelInterface demo;
	public static void exec(StepCmd step) 
	{
		if (! initialized)
		{
			demo = new WheelInterface();
		    JFrame frame = new JFrame();
		    Container cp = frame.getContentPane();
		    cp.add(demo,BorderLayout.CENTER);

		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setSize(500, 500);
		    frame.setLocation(500, 500);
		    frame.setVisible(true);
		    initialized = true;
		}
		if (step.getReaction())
		{
			Output.output ("[MOTOR] should react");
			demo.addIncrement(1);
		}
		else
		{
			Output.output ("[MOTOR] should not react");
		}
	}

}
