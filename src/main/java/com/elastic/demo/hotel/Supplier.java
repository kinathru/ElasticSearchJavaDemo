package com.elastic.demo.hotel;

import java.util.List;

/**
 * Created by Kinath on 6/8/2017.
 */
public class Supplier
{
    private long supplierId;
    private String supplierName;

    private List<Hotel> suppHotels;

    public long getSupplierId()
    {
        return supplierId;
    }

    public void setSupplierId( long supplierId )
    {
        this.supplierId = supplierId;
    }

    public String getSupplierName()
    {
        return supplierName;
    }

    public void setSupplierName( String supplierName )
    {
        this.supplierName = supplierName;
    }

    public List<Hotel> getSuppHotels()
    {
        return suppHotels;
    }

    public void setSuppHotels( List<Hotel> suppHotels )
    {
        this.suppHotels = suppHotels;
    }
}
