import java.util.ArrayList;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A system of voice mail boxes.

 Solves CS151 homework assignment #3

 @author Scot Matson
 Adapted from Object-Oriented Design & Patterns by Cay Horstmann

 @version 1.01 2015/10/25
 */
public class MailSystem
{
   /**
      Constructs a mail system with a given number of mail boxes
      @param mailboxCount the number of mailboxes
   */
   public MailSystem(int mailboxCount)
   {
      mailboxes = new ArrayList<Mailbox>(mailboxCount);

      /*
         Initialize mail boxes.
      */
      for (int i = 0; i < mailboxCount; i++)
      {
         String passcode = "" + (i + 1);
         String greeting = "You have reached mailbox " + (i + 1)
            + ". \nPlease leave a message now.";
         mailboxes.add(i, new Mailbox(passcode, greeting));
      }
   }

   /**
      Locate a mailbox.
      @param ext the extension number
      @return the mailbox or null if not found
   */
   public Mailbox findMailbox(String ext)
   {
      int i = Integer.parseInt(ext);
      if (1 <= i && i <= mailboxes.size())
         return mailboxes.get(i - 1);
      else return null;
   }

   private ArrayList<Mailbox> mailboxes;
}