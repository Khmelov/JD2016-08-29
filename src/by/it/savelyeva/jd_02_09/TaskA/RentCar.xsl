<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Persons">
        <table border="1">
            <tr>
                <td>FirstName</td>
                <td>LastName</td>
                <td>Sex</td>
                <td>DateOfBirth</td>
                <td>Passport</td>
                <td>IssuedBy</td>
                <td>IssuedDate</td>
                <td>Login</td>
                <td>Password</td>
                <td>Phone</td>
                <td>Address</td>
                <td>DriverLicence</td>
                <td>Orders</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="Persons/Person">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="Persons/Person/FirstName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/LastName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/Sex">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/DateOfBirth">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/Passport">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/IssuedBy">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/IssuedDate">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/Phone">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/Address">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/DriverLicence">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Persons/Person/DriverLicence/Serial">
        Serial: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/DriverLicence/Cathegory">
        Cathegory: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/DriverLicence/Active">
        Active: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/DriverLicence/Issued">
        Issued: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/DriverLicence/Expire">
        Expire: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="Persons/Person/Orders/Car">
        <xsl:apply-templates/><hr/>
    </xsl:template>

    <xsl:template match="Persons/Person/Orders/Car/Manufacturer">
        Manufacturer: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/Model">
        Model: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/Year">
        Year: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/Color">
        Color: <xsl:apply-templates/><br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/Transmission">
        Transmission: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/RecentInsurance">
        Insurance: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/Available">
        Ready for order: <xsl:apply-templates/> <br/>
    </xsl:template>

    <xsl:template match="Persons/Person/Orders/Car/Photos/Photo">
        <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/Rents/Rent">
        Rented previously:<br/> <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/Rents/Rent/BeginDate">
        taken: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Persons/Person/Orders/Car/Rents/Rent/EndDate">
        back: <xsl:apply-templates/> <br/>
    </xsl:template>



</xsl:stylesheet>