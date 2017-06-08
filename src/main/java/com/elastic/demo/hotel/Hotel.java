package com.elastic.demo.hotel;

import java.util.List;

/**
 * Created by Kinath on 6/8/2017.
 */
public class Hotel
{
    private long supplierId;
    private long hotelId;
    private String hotelName;
    private String address;
    private int starRating;
    private String country;
    private String city;

    private List<Room> hotelRooms;
    private List<BoardBasis> boardBases;

    public long getSupplierId()
    {
        return supplierId;
    }

    public void setSupplierId( long supplierId )
    {
        this.supplierId = supplierId;
    }

    public long getHotelId()
    {
        return hotelId;
    }

    public void setHotelId( long hotelId )
    {
        this.hotelId = hotelId;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName( String hotelName )
    {
        this.hotelName = hotelName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public int getStarRating()
    {
        return starRating;
    }

    public void setStarRating( int starRating )
    {
        this.starRating = starRating;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry( String country )
    {
        this.country = country;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity( String city )
    {
        this.city = city;
    }

    public List<Room> getHotelRooms()
    {
        return hotelRooms;
    }

    public void setHotelRooms( List<Room> hotelRooms )
    {
        this.hotelRooms = hotelRooms;
    }

    public List<BoardBasis> getBoardBases()
    {
        return boardBases;
    }

    public void setBoardBases( List<BoardBasis> boardBases )
    {
        this.boardBases = boardBases;
    }
}
