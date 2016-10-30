<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/PaymentSystem">
        <body><xsl:apply-templates/></body>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Clients">
        <table border ="1"><xsl:value-of select="node()"/></table>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Accounts">
        <table border="1"><xsl:apply-templates/></table>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Admin">
        <table border="1"><tr><xsl:apply-templates/></tr></table>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Clients/Client">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Accounts/Account">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Clients/Client/Email">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Clients/Client/Login">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Clients/Client/Password">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/PaymentSystem/Accounts/Account/TotalAmount">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Accounts/Account/Status">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

    <xsl:template match="/PaymentSystem/Admin/Password">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template>
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>
    <xsl:template match="/PaymentSystem/Admin/UnlockAccount">
        <td><xsl:value-of select="text()"/></td>
    </xsl:template>

</xsl:stylesheet>