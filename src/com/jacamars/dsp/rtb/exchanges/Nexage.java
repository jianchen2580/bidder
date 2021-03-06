package com.jacamars.dsp.rtb.exchanges;

import java.io.IOException;

import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jacamars.dsp.rtb.pojo.BidRequest;

/**
 * A Bid request for Nexage. Exchanges can introduce their own JSON into the bid request, so all the
 * special parsing is done in a class that extends the BidRequest. All standard bid requests are handled
 * in the BidRequest super class. The exchange only handles those values specific to the exchange.
 * <p>
 * The interrogate() method of the base class is used to retrieve the object values from the class.
 * @author Ben M. Faul
 *
 */
public class Nexage extends BidRequest {
	
	/**
	 * Make a default constructor, the bidder keeps a representative class instance for each
	 * exchange so it can use a Map to make new bid requests per the format of the bid request.
	 */
	public Nexage() {
		super();
		parseSpecial();
	}
	
	/**
	 * Constructs Nexage bid request from a file containoing JSON
	 * @param in. String - the File name containing the data.
	 * @throws JsonProcessingException on parse errors.
	 * @throws IOException on file reading errors.
	 */	
	public Nexage(String  in) throws Exception  {
		super(in);
		parseSpecial();
    }	
	
	/**
	 * Constructs Nexage bid request from JSON stream in jetty.
	 * @param in. InputStream - the JSON data coming from HTTP.
	 * @throws JsonProcessingException on parse errors.
	 * @throws IOException on file reading errors.
	 */
	public Nexage(InputStream in) throws Exception {
		super(in);
		parseSpecial();
	}
	
	/**
	 * Debugging version of the constructor. Will dump if there is a problem
	 * @param in InputStream. The JSON input
	 * @param e String. The exchange name
	 * @throws Exception will dump the error, and set the blackist flag.
	 */
	public Nexage(InputStream in, String e) throws Exception {
		super(in,"nexage");
	}
	
	/**
	 * Create a new Nexage object from this class instance. To debug, do return new Nexage(in, "nexage");
	 * @throws JsonProcessingException on parse errors.
	 * @throws Exception on stream reading errors
	 */
	@Override
	public Nexage copy(InputStream in) throws Exception  {
		Nexage copy =  new Nexage(in);
		copy.usesEncodedAdm = usesEncodedAdm;
		return copy;
	}
	
	/**
	 * Process special Nexage stuff, sets the exchange name.
	 */
	@Override
	public boolean parseSpecial() {
		setExchange( "nexage" );
		return true;
	}
	
}
