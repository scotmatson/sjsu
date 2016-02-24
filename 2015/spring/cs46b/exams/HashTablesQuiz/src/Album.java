public class Album
{
	private String artist;
	private String name;
	
	public Album(String artist, String name)
	{
		this.artist = artist;
		this.name = name;
	}
	
	public String getArtist(){ return artist; }
	public String getName(){ return name; }
	
	public void setArtist(String artist){ this.artist = artist; }
	public void setName(String name){ this.name = name; }

	@Override
	public String toString()
	{
		return this.name + " by " + this.artist;
	}
	
	@Override
	public int hashCode()
	{
		return this.name.hashCode() * this.artist.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		if( o == null ) return false;
		
		if( o instanceof Album )
		{
			Album b = (Album)o;
			
			return this.getArtist().equals(b.getArtist()) && this.getName().equals(b.getName());
		}
		
		return false;
	}
}