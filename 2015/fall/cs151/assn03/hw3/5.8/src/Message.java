/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A message left by the caller.

 Solves CS151 homework assignment #3

 @author Scot Matson
 Adapted from Object-Oriented Design & Patterns by Cay Horstmann

 @version 1.01 2015/10/25
 */
public class Message
{
   /**
      Construct a Message object.
      @param messageText the message text
   */
   public Message(String messageText)
   {
      text = messageText;
   }

   /**
      Get the message text.
      @return message text
   */
   public String getText()
   {
      return text;
   }

   private String text;
}