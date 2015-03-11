package me.bukkit.koarl91.CommandHandler;

import java.io.IOException;

import org.bukkit.command.CommandSender;

import me.bukkit.koarl91.cli.Command;
import me.bukkit.koarl91.cli.Shell;

public class CommandHandler 
{
	private Shell shell;
	public CommandHandler()
	{		
		initShell();
	}
	@Command
	public String hello(CommandSender sender) throws IOException
    {
    	return "Hallo!!!!\nDas ist ein Test";
    }
	
	/**
	 * Initializes the interactive shell.
	 * @param userRequestStream the input stream to read user input from
	 * @param userResponseStream the output stream to write the console output to
	 */
    private void initShell() 
    {
    	shell = new Shell("Command Shell");
        shell.register(this);
    }
	public void exit() 
	{
		shell.close();		
	}

	public boolean cmd(CommandSender sender,
			org.bukkit.command.Command command, String label, String[] args) 
	{
		String arguments="";
        for(int i=0; i<args.length;i++)
        {
            if(arguments.equals("")) arguments = "" + args;
            else arguments += " " +args;
        }
        try 
        {
        	if(arguments.equals("")) sender.sendMessage(shell.invoke("/"+command, sender).toString());
        	else sender.sendMessage(shell.invoke("/"+command.getName() + " " + arguments, sender).toString());
			return true;
		} 
        catch (Throwable e) 
        {
			return false;
		}
	}
}
