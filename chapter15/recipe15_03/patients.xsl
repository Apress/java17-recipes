<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Patients</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Diagnosis</th>
                    </tr>
                    <xsl:for-each select="patients/patient">
                        <tr>
                            <td>
                                <xsl:value-of select="@id"/>
                            </td>                               
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="diagnosis"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                    
                </table>
                    
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>