<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/PaymentSystem">
        <table border="1">
            <tr>
                <td>Clients</td>
                <td>Accounts</td>
                <td>Admin</td>
            </tr>
        </table>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Clients">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Accounts">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Admin">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Clients">
        <table>
            <tr><td>Email</td><td>Login</td><td>Password</td></tr>
        </table>
    </xsl:template>
    <xsl:template match="/Clients/Client">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Clients/Client/Email">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Clients/Client/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Accounts">
        <table>
            <tr><td>TotalAmount</td><td>Status</td></tr>
        </table>
    </xsl:template>
    <xsl:template match="/Accounts/Account">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Accounts/Account/TotalAmount">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Accounts/Account/Status">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Admin">
        <table border="1">
            <tr><td>Email</td><td>Login</td><td>Password</td></tr>
        </table>
    </xsl:template>
    <xsl:template match="/Admin">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Admin/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Admin/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Admin/UnlockAccount">
        <table><xsl:apply-templates/></table>
    </xsl:template>

    <xsl:template match="/UnlockAccount">
        <table>
            <tr><td>getId</td></tr>
        </table>
    </xsl:template>
    <xsl:template match="/UnlockAccount">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/UnlockAccount/geId">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>