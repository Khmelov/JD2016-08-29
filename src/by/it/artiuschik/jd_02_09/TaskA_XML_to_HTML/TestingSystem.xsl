<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Students">
        <table border="1">
            <tr>
                <td>
                    Name
                </td>
                <td>
                    Surname
                </td>
                <td>
                    Course
                </td>
                <td>
                    Test
                </td>
                <td>
                    Question#1
                </td>
                <td>
                    Question#2
                </td>
                <td>
                    Question#3
                </td>
                <td>
                    Result
                </td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Students/Student">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Students/Student/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Students/Student/Surname">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Students/Student/Course">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Students/Student/Test">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Students/Student/Test/question">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Students/Student/Result">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>