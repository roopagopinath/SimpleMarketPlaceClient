<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleMarketPlaceProxyid" scope="session" class="lab2.Question2.MarketPlace.MarketPlaceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleMarketPlaceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleMarketPlaceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleMarketPlaceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        lab2.Question2.MarketPlace.MarketPlace getMarketPlace10mtemp = sampleMarketPlaceProxyid.getMarketPlace();
if(getMarketPlace10mtemp == null){
%>
<%=getMarketPlace10mtemp %>
<%
}else{
        if(getMarketPlace10mtemp!= null){
        String tempreturnp11 = getMarketPlace10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String buyerID_1id=  request.getParameter("buyerID16");
            java.lang.String buyerID_1idTemp = null;
        if(!buyerID_1id.equals("")){
         buyerID_1idTemp  = buyerID_1id;
        }
        String sellerID_2id=  request.getParameter("sellerID18");
            java.lang.String sellerID_2idTemp = null;
        if(!sellerID_2id.equals("")){
         sellerID_2idTemp  = sellerID_2id;
        }
        String itemID_3id=  request.getParameter("itemID20");
        int itemID_3idTemp  = Integer.parseInt(itemID_3id);
        String quantity_4id=  request.getParameter("quantity22");
        int quantity_4idTemp  = Integer.parseInt(quantity_4id);
        String addToCart_5id=  request.getParameter("addToCart24");
        boolean addToCart_5idTemp  = Boolean.valueOf(addToCart_5id).booleanValue();
        boolean updateShoppingCart13mtemp = sampleMarketPlaceProxyid.updateShoppingCart(buyerID_1idTemp,sellerID_2idTemp,itemID_3idTemp,quantity_4idTemp,addToCart_5idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateShoppingCart13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 26:
        gotMethod = true;
        String buyerID_6id=  request.getParameter("buyerID29");
            java.lang.String buyerID_6idTemp = null;
        if(!buyerID_6id.equals("")){
         buyerID_6idTemp  = buyerID_6id;
        }
        java.lang.String[] displayAdvertisement26mtemp = sampleMarketPlaceProxyid.displayAdvertisement(buyerID_6idTemp);
if(displayAdvertisement26mtemp == null){
%>
<%=displayAdvertisement26mtemp %>
<%
}else{
        String tempreturnp27 = null;
        if(displayAdvertisement26mtemp != null){
        java.util.List listreturnp27= java.util.Arrays.asList(displayAdvertisement26mtemp);
        tempreturnp27 = listreturnp27.toString();
        }
        %>
        <%=tempreturnp27%>
        <%
}
break;
case 31:
        gotMethod = true;
        String itemName_7id=  request.getParameter("itemName34");
            java.lang.String itemName_7idTemp = null;
        if(!itemName_7id.equals("")){
         itemName_7idTemp  = itemName_7id;
        }
        String itemDesc_8id=  request.getParameter("itemDesc36");
            java.lang.String itemDesc_8idTemp = null;
        if(!itemDesc_8id.equals("")){
         itemDesc_8idTemp  = itemDesc_8id;
        }
        String price_9id=  request.getParameter("price38");
        float price_9idTemp  = Float.parseFloat(price_9id);
        String quantity_10id=  request.getParameter("quantity40");
        int quantity_10idTemp  = Integer.parseInt(quantity_10id);
        String userID_11id=  request.getParameter("userID42");
            java.lang.String userID_11idTemp = null;
        if(!userID_11id.equals("")){
         userID_11idTemp  = userID_11id;
        }
        boolean storeAdvertisement31mtemp = sampleMarketPlaceProxyid.storeAdvertisement(itemName_7idTemp,itemDesc_8idTemp,price_9idTemp,quantity_10idTemp,userID_11idTemp);
        String tempResultreturnp32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(storeAdvertisement31mtemp));
        %>
        <%= tempResultreturnp32 %>
        <%
break;
case 44:
        gotMethod = true;
        String userID_12id=  request.getParameter("userID47");
            java.lang.String userID_12idTemp = null;
        if(!userID_12id.equals("")){
         userID_12idTemp  = userID_12id;
        }
        sampleMarketPlaceProxyid.signOut(userID_12idTemp);
break;
case 49:
        gotMethod = true;
        String buyerID_13id=  request.getParameter("buyerID52");
            java.lang.String buyerID_13idTemp = null;
        if(!buyerID_13id.equals("")){
         buyerID_13idTemp  = buyerID_13id;
        }
        boolean buyProduct49mtemp = sampleMarketPlaceProxyid.buyProduct(buyerID_13idTemp);
        String tempResultreturnp50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(buyProduct49mtemp));
        %>
        <%= tempResultreturnp50 %>
        <%
break;
case 54:
        gotMethod = true;
        String buyerID_14id=  request.getParameter("buyerID57");
            java.lang.String buyerID_14idTemp = null;
        if(!buyerID_14id.equals("")){
         buyerID_14idTemp  = buyerID_14id;
        }
        java.lang.String[] buy54mtemp = sampleMarketPlaceProxyid.buy(buyerID_14idTemp);
if(buy54mtemp == null){
%>
<%=buy54mtemp %>
<%
}else{
        String tempreturnp55 = null;
        if(buy54mtemp != null){
        java.util.List listreturnp55= java.util.Arrays.asList(buy54mtemp);
        tempreturnp55 = listreturnp55.toString();
        }
        %>
        <%=tempreturnp55%>
        <%
}
break;
case 59:
        gotMethod = true;
        String sellerID_15id=  request.getParameter("sellerID62");
            java.lang.String sellerID_15idTemp = null;
        if(!sellerID_15id.equals("")){
         sellerID_15idTemp  = sellerID_15id;
        }
        java.lang.String[] sell59mtemp = sampleMarketPlaceProxyid.sell(sellerID_15idTemp);
if(sell59mtemp == null){
%>
<%=sell59mtemp %>
<%
}else{
        String tempreturnp60 = null;
        if(sell59mtemp != null){
        java.util.List listreturnp60= java.util.Arrays.asList(sell59mtemp);
        tempreturnp60 = listreturnp60.toString();
        }
        %>
        <%=tempreturnp60%>
        <%
}
break;
case 64:
        gotMethod = true;
        String buyerID_16id=  request.getParameter("buyerID67");
            java.lang.String buyerID_16idTemp = null;
        if(!buyerID_16id.equals("")){
         buyerID_16idTemp  = buyerID_16id;
        }
        java.lang.String[] viewCart64mtemp = sampleMarketPlaceProxyid.viewCart(buyerID_16idTemp);
if(viewCart64mtemp == null){
%>
<%=viewCart64mtemp %>
<%
}else{
        String tempreturnp65 = null;
        if(viewCart64mtemp != null){
        java.util.List listreturnp65= java.util.Arrays.asList(viewCart64mtemp);
        tempreturnp65 = listreturnp65.toString();
        }
        %>
        <%=tempreturnp65%>
        <%
}
break;
case 69:
        gotMethod = true;
        String first_name_17id=  request.getParameter("first_name72");
            java.lang.String first_name_17idTemp = null;
        if(!first_name_17id.equals("")){
         first_name_17idTemp  = first_name_17id;
        }
        String last_name_18id=  request.getParameter("last_name74");
            java.lang.String last_name_18idTemp = null;
        if(!last_name_18id.equals("")){
         last_name_18idTemp  = last_name_18id;
        }
        String emailID_19id=  request.getParameter("emailID76");
            java.lang.String emailID_19idTemp = null;
        if(!emailID_19id.equals("")){
         emailID_19idTemp  = emailID_19id;
        }
        String password_20id=  request.getParameter("password78");
            java.lang.String password_20idTemp = null;
        if(!password_20id.equals("")){
         password_20idTemp  = password_20id;
        }
        String userID_21id=  request.getParameter("userID80");
            java.lang.String userID_21idTemp = null;
        if(!userID_21id.equals("")){
         userID_21idTemp  = userID_21id;
        }
        boolean signUp69mtemp = sampleMarketPlaceProxyid.signUp(first_name_17idTemp,last_name_18idTemp,emailID_19idTemp,password_20idTemp,userID_21idTemp);
        String tempResultreturnp70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signUp69mtemp));
        %>
        <%= tempResultreturnp70 %>
        <%
break;
case 82:
        gotMethod = true;
        String userID_22id=  request.getParameter("userID85");
            java.lang.String userID_22idTemp = null;
        if(!userID_22id.equals("")){
         userID_22idTemp  = userID_22id;
        }
        String password_23id=  request.getParameter("password87");
            java.lang.String password_23idTemp = null;
        if(!password_23id.equals("")){
         password_23idTemp  = password_23id;
        }
        java.lang.String signIn82mtemp = sampleMarketPlaceProxyid.signIn(userID_22idTemp,password_23idTemp);
if(signIn82mtemp == null){
%>
<%=signIn82mtemp %>
<%
}else{
        String tempResultreturnp83 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signIn82mtemp));
        %>
        <%= tempResultreturnp83 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>