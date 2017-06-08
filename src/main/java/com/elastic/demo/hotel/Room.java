package com.elastic.demo.hotel;

import java.util.List;

/**
 * Created by Kinath on 6/8/2017.
 */
public class Room
{
    private long hotelId;
    private String roomCode;
    private String roomName;
    private String occupancy;

    private List<RoomFacility> roomFacilities;

    public long getHotelId()
    {
        return hotelId;
    }

    public void setHotelId( long hotelId )
    {
        this.hotelId = hotelId;
    }

    public String getRoomCode()
    {
        return roomCode;
    }

    public void setRoomCode( String roomCode )
    {
        this.roomCode = roomCode;
    }

    public String getRoomName()
    {
        return roomName;
    }

    public void setRoomName( String roomName )
    {
        this.roomName = roomName;
    }

    public String getOccupancy()
    {
        return occupancy;
    }

    public void setOccupancy( String occupancy )
    {
        this.occupancy = occupancy;
    }

    public List<RoomFacility> getRoomFacilities()
    {
        return roomFacilities;
    }

    public void setRoomFacilities( List<RoomFacility> roomFacilities )
    {
        this.roomFacilities = roomFacilities;
    }
}
