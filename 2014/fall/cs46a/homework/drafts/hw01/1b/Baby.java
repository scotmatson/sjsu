public class Baby
{
    public static void main(String[] args)
    {
        Picture babyTaran = new Picture("taran_avatar.jpg");
        babyTaran.translate(150, 100);
        babyTaran.grow(50, 50);
        babyTaran.draw();
    }
}