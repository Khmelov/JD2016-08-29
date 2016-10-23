<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Hotel">
        <table border="1" width="1280px">
            <tr>
                <td align="center" colspan="7">Clients</td>
            </tr>
            <tr>
                <td align="center">name</td>
                <td align="center">surname</td>
                <td align="center">middlename</td>
                <td align="center">email</td>
                <td align="center">passport</td>
                <td align="center">login</td>
                <td align="center">password</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Hotel/Clients/client">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/Hotel/Clients/client/name">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Clients/client/surname">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Clients/client/middleName">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Clients/client/email">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Clients/client/passport">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Clients/client/login">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Clients/client/password">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Hotel/Apartments">
        <table border="1" width="1280px">
            <tr>
                <td align="center" colspan="6">Apartments</td>
            </tr>
            <tr>
                <td align="center">floor</td>
                <td align="center">room_number</td>
                <td align="center">places</td>
                <td align="center">category</td>
                <td align="center">cost</td>
                <td align="center">status</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Hotel/Apartments/apartment">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/Hotel/Apartments/apartment/floor">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Apartments/apartment/room_number">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Apartments/apartment/places">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Apartments/apartment/category">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Apartments/apartment/cost">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Apartments/apartment/status">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

    <xsl:template match="/Hotel/Orders">
        <table border="1" width="1280px">
            <tr>
                <td align="center" colspan="5">Orders</td>
            </tr>
            <tr>
                <td align="center">user_id</td>
                <td align="center">apartment_id</td>
                <td align="center">arrive_date</td>
                <td align="center">return_date</td>
                <td align="center">bill</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="/Hotel/Orders/order">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="/Hotel/Orders/order/user_id">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Orders/order/apartment_id">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Orders/order/arrive_date">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Orders/order/return_date">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="/Hotel/Orders/order/bill">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>

</xsl:stylesheet>
