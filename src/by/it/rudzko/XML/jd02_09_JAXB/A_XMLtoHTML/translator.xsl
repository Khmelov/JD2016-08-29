<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/periodicals">
    <meta charset="utf-8"/>
        <table border="0" cellpadding="10">
            <tr>
                <td>Journal/Paper</td><td>Topics</td><td>Frequency</td>
                <td>Site</td><td>Index</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>


    <xsl:template match="/periodicals/journals/journal">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/periodicals/journals/journal/name">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/periodicals/journals/journal/topic">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/periodicals/journals/journal/frequency">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/periodicals/journals/journal/index">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/periodicals/journals/journal/site">
        <td><xsl:apply-templates/></td>
    </xsl:template>


    <xsl:template match="/periodicals/papers/paper">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/periodicals/papers/paper/name">
       <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/periodicals/papers/paper/topic">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/periodicals/papers/paper/frequency">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/periodicals/papers/paper/index">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/periodicals/papers/paper/site">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>