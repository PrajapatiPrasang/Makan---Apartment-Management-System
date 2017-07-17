<%@ page import="java.util.*" %>
<%@ page import="java.security.*" %>

<%!
public boolean empty(String s)
	{
		if(s== null || s.trim().equals(""))
			return true;
		else
			return false;
	}
%>
<%!
	public String hashCal(String type,String str){
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try{
		MessageDigest algorithm = MessageDigest.getInstance(type);
		algorithm.reset();
		algorithm.update(hashseq);
		byte messageDigest[] = algorithm.digest();
            
		
		for (int i=0;i<messageDigest.length;i++) {
			String hex=Integer.toHexString(0xFF & messageDigest[i]);
			if(hex.length()==1) hexString.append("0");
			hexString.append(hex);
		}
			
		}catch(NoSuchAlgorithmException nsae){ }
		
		return hexString.toString();
	}
%>
<% 	
	String merchant_key="gtKFFx";
	String salt="eCwWELxi";
	String action1 ="";
	String base_url="https://test.payu.in";
	int error=0;
	String hashString="";
	
 
	
	Enumeration paramNames = request.getParameterNames();
	Map<String,String> params= new HashMap<String,String>();
    	while(paramNames.hasMoreElements()) 
	{
      		String paramName = (String)paramNames.nextElement();
      
      		String paramValue = request.getParameter(paramName);
		params.put(paramName,paramValue);
	}
	String txnid ="";
	if(empty(params.get("txnid"))){
		Random rand = new Random();
		String rndm = Integer.toString(rand.nextInt())+(System.currentTimeMillis() / 1000L);
		txnid=hashCal("SHA-256",rndm).substring(0,20);
	}
	else
		txnid=params.get("txnid");
	String txn="abcd";
	String hash="";
	String hashSequence = "key|txnid|amount|productinfo|firstname|email|udf1|udf2|udf3|udf4|udf5|udf6|udf7|udf8|udf9|udf10";
	if(empty(params.get("hash")) && params.size()>0)
	{
		if( empty(params.get("key"))
			|| empty(params.get("txnid"))
			|| empty(params.get("amount"))
			|| empty(params.get("firstname"))
			|| empty(params.get("email"))
			|| empty(params.get("phone"))
			|| empty(params.get("productinfo"))
			|| empty(params.get("surl"))
			|| empty(params.get("furl"))	)
			
			error=1;
		else{
			String[] hashVarSeq=hashSequence.split("\\|");
			
			for(String part : hashVarSeq)
			{
				hashString= (empty(params.get(part)))?hashString.concat(""):hashString.concat(params.get(part));
				hashString=hashString.concat("|");
			}
			hashString=hashString.concat(salt);
			
			 hash=hashCal("SHA-512",hashString);
			action1=base_url.concat("/_payment");
		}
	}
	else if(!empty(params.get("hash")))
	{
		hash=params.get("hash");
		action1=base_url.concat("/_payment");
	}
		
%>
<html>
<script>
var hash='9082e6f8d1c5d3868a49fb4395694fcb925c9051e57b09b7023be023400755e5b28cb2b436af6ccf20e96c1eec214a3b6429c5d8cbdaed5bbb786b6545566eac';
function submitPayuForm() {
	
	if (hash == '')
		return;
      var payuForm = document.forms.payuForm;
      payuForm.submit();
    }
</script>
<style>
 #submit_button
    {    
        visibility: hidden;
    }
</style>

<body onload="submitPayuForm();">


<form action="<%= action1 %>" method="post" name="payuForm">
<input type="hidden" name="key" value="<%= merchant_key %>" />
      <input type="hidden" name="hash" value="<%= hash %>"/>
      <input type="hidden" name="txnid" value="<%= txnid %>" />
      <table>
        
        <tr>
          <!-- <td>Amount: </td> -->
          <td><input name="amount" value="<%=session.getAttribute("rent1") %>" type="hidden"/></td>
          <!-- <td>First Name: </td> -->
          <td><input name="firstname" id="firstname" value="<%=session.getAttribute("firstname1") %>" type="hidden"/></td>
        </tr>
        <tr>
         <!--  <td>Email: </td> -->
          <td><input name="email" id="email" value="<%=session.getAttribute("emailId1") %>" type="hidden" /></td>
         <!--  <td>Phone: </td> -->
          <td><input name="phone" value="<%=session.getAttribute("phoneNo1") %>" type="hidden"/></td>
        </tr>
        <tr>
          <!-- <td>Product Info: </td> -->
          <td colspan="3"><input name="productinfo" value="rent" size="64" type="hidden" /></td>
        </tr>
        <tr>
          <!-- <td>Success URI: </td> -->
          <td colspan="3"><input name="surl" value="<%=session.getAttribute("surl") %>" size="64" type="hidden"/></td>
        </tr>
        <tr>
          <!-- <td>Failure URI: </td> -->
          <td colspan="3"><input name="furl" value="<%=session.getAttribute("furl") %>" size="64" type="hidden"/></td>
        </tr>
        <tr>
          <!-- <td><b>Optional Parameters</b></td> -->
        </tr>
        <tr>
         <!--  <td>Last Name: </td> -->
          <td><input name="lastname" id="lastname" value="<%= (empty(params.get("lastname"))) ? "" : params.get("lastname") %>" type="hidden"/></td>
          <!-- <td>Cancel URI: </td> -->
          <td><input name="curl" value="" type="hidden"/></td>
        </tr>
        <tr>
          <!-- <td>Address1: </td> -->
          <td><input name="address1" value="<%= (empty(params.get("address1"))) ? "" : params.get("address1") %>" type="hidden"/></td>
          <!-- <td>Address2: </td> -->
          <td><input name="address2" value="<%= (empty(params.get("address2"))) ? "" : params.get("address2") %>" type="hidden"/></td>
        </tr>
        <tr>
          <!-- <td>City: </td> -->
          <td><input name="city" value="<%= (empty(params.get("city"))) ? "" : params.get("city") %>" type="hidden"/></td>
          <!-- <td>State: </td> -->
          <td><input name="state" value="<%= (empty(params.get("state"))) ? "" : params.get("state") %>" type="hidden" /></td>
        </tr>
        <tr>
          <!-- <td>Country: </td> -->
          <td><input name="country" value="<%= (empty(params.get("country"))) ? "" : params.get("country") %>" type="hidden"/></td>
          <!-- <td>Zipcode: </td> -->
          <td><input name="zipcode" value="<%= (empty(params.get("zipcode"))) ? "" : params.get("zipcode") %>" type="hidden"/></td>
        </tr>
        <tr>
         <!--  <td>UDF1: </td> -->
          <td><input name="udf1" value="<%= (empty(params.get("udf1"))) ? "" : params.get("udf1") %>" type="hidden"/></td>
          <!-- <td>UDF2: </td> -->
          <td><input name="udf2" value="<%= (empty(params.get("udf2"))) ? "" : params.get("udf2") %>" type="hidden"/></td>
        </tr>
        <tr>
          <!-- <td>UDF3: </td> -->
          <td><input name="udf3" value="<%= (empty(params.get("udf3"))) ? "" : params.get("udf3") %>" type="hidden" /></td>
         <!--  <td>UDF4: </td> -->
          <td><input name="udf4" value="<%= (empty(params.get("udf4"))) ? "" : params.get("udf4") %>" type="hidden"/></td>
        </tr>
        <tr>
         <!--  <td>UDF5: </td> -->
          <td><input name="udf5" value="<%= (empty(params.get("udf5"))) ? "" : params.get("udf5") %>" type="hidden"/></td>
         <!--  <td>PG: </td> -->
          <td><input name="pg" value="<%= (empty(params.get("pg"))) ? "" : params.get("pg") %>" type="hidden"/></td>
        </tr>
        <tr>
          <% if(empty(hash)){ %>
            <td colspan="4"><input type="submit" value="Submit" id="submit_button"/></td>
          <% } %>
        </tr>
      </table>
    </form>
	<h1>Processing.....</h1>

</body>
</html>
