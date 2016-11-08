<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/Hospital">
        <meta charset="utf-8"/>
        <table border="1" cellpadding="10">
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
                <td>MedicalCard</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>


    <xsl:template match="Hospital/Patients/Patient">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/FirstName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/LastName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/Sex">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/DateOfBirth">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/Passport">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/IssuedBy">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/IssuedDate">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/Login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/Password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/Phone">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/Address">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/MedicalCard">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="Hospital/Patients/Patient/MedicalCard/Diagnosis">
        <xsl:apply-templates/> <hr/>
    </xsl:template>
    <xsl:template match="Hospital/Patients/Patient/MedicalCard/Diagnosis/Disease">
        Disease: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Hospital/Patients/Patient/MedicalCard/Diagnosis/Sibptomps">
        Sibptomps: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Hospital/Patients/Patient/MedicalCard/Diagnosis/PeriodStart">
        PeriodStart: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Hospital/Patients/Patient/MedicalCard/Diagnosis/PeriodEnd">
        PeriodEnd: <xsl:apply-templates/> <br/>
    </xsl:template>
    <xsl:template match="Hospital/Patients/Patient/MedicalCard/Diagnosis/Recipe">
        Recipe: <xsl:apply-templates/> <br/>
    </xsl:template>


</xsl:stylesheet>