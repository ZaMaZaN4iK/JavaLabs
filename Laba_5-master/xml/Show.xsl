<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl">
<xsl:template match="/">
</xsl:template>
<body style="font-family: Arial; font-size: 12pt; background-color: #EEE">
   <xsl:for-each select="Engineer">
      <div style="background-color: teal; color: white; padding: 4px">
         <span style="font-weight: bold"><xsl:value-of select="name"/> - </span>
         <xsl:value-of select="surname"/>
      </div>
      <div style="margin-left: 20px; margin-bottom: 1em; font-size: 10pt">
         <p>
            <xsl:value-of select="middleName"/>
            <span style="font-style: italic"><xsl:value-of select="age"/></span>
         </p>
      </div>
   </xsl:for-each>
</body>
</html>
</xsl:stylesheet> 