/**
 * Atividades.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package movimentacao.webservice;

public class Atividades  implements java.io.Serializable {
    private java.util.Date data;

    private boolean finalizado;

    private java.lang.Integer id;

    private movimentacao.webservice.Negocios negocios;

    private java.lang.String obs;

    private java.util.Date prazo;

    private java.lang.String tipoAtividade;

    private movimentacao.webservice.Usuario usuario;

    public Atividades() {
    }

    public Atividades(
           java.util.Date data,
           boolean finalizado,
           java.lang.Integer id,
           movimentacao.webservice.Negocios negocios,
           java.lang.String obs,
           java.util.Date prazo,
           java.lang.String tipoAtividade,
           movimentacao.webservice.Usuario usuario) {
           this.data = data;
           this.finalizado = finalizado;
           this.id = id;
           this.negocios = negocios;
           this.obs = obs;
           this.prazo = prazo;
           this.tipoAtividade = tipoAtividade;
           this.usuario = usuario;
    }


    /**
     * Gets the data value for this Atividades.
     * 
     * @return data
     */
    public java.util.Date getData() {
        return data;
    }


    /**
     * Sets the data value for this Atividades.
     * 
     * @param data
     */
    public void setData(java.util.Date data) {
        this.data = data;
    }


    /**
     * Gets the finalizado value for this Atividades.
     * 
     * @return finalizado
     */
    public boolean isFinalizado() {
        return finalizado;
    }


    /**
     * Sets the finalizado value for this Atividades.
     * 
     * @param finalizado
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }


    /**
     * Gets the id value for this Atividades.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Atividades.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the negocios value for this Atividades.
     * 
     * @return negocios
     */
    public movimentacao.webservice.Negocios getNegocios() {
        return negocios;
    }


    /**
     * Sets the negocios value for this Atividades.
     * 
     * @param negocios
     */
    public void setNegocios(movimentacao.webservice.Negocios negocios) {
        this.negocios = negocios;
    }


    /**
     * Gets the obs value for this Atividades.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this Atividades.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the prazo value for this Atividades.
     * 
     * @return prazo
     */
    public java.util.Date getPrazo() {
        return prazo;
    }


    /**
     * Sets the prazo value for this Atividades.
     * 
     * @param prazo
     */
    public void setPrazo(java.util.Date prazo) {
        this.prazo = prazo;
    }


    /**
     * Gets the tipoAtividade value for this Atividades.
     * 
     * @return tipoAtividade
     */
    public java.lang.String getTipoAtividade() {
        return tipoAtividade;
    }


    /**
     * Sets the tipoAtividade value for this Atividades.
     * 
     * @param tipoAtividade
     */
    public void setTipoAtividade(java.lang.String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }


    /**
     * Gets the usuario value for this Atividades.
     * 
     * @return usuario
     */
    public movimentacao.webservice.Usuario getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this Atividades.
     * 
     * @param usuario
     */
    public void setUsuario(movimentacao.webservice.Usuario usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Atividades)) return false;
        Atividades other = (Atividades) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            this.finalizado == other.isFinalizado() &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.negocios==null && other.getNegocios()==null) || 
             (this.negocios!=null &&
              this.negocios.equals(other.getNegocios()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.prazo==null && other.getPrazo()==null) || 
             (this.prazo!=null &&
              this.prazo.equals(other.getPrazo()))) &&
            ((this.tipoAtividade==null && other.getTipoAtividade()==null) || 
             (this.tipoAtividade!=null &&
              this.tipoAtividade.equals(other.getTipoAtividade()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        _hashCode += (isFinalizado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNegocios() != null) {
            _hashCode += getNegocios().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
        }
        if (getPrazo() != null) {
            _hashCode += getPrazo().hashCode();
        }
        if (getTipoAtividade() != null) {
            _hashCode += getTipoAtividade().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Atividades.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "atividades"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("finalizado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "finalizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("negocios");
        elemField.setXmlName(new javax.xml.namespace.QName("", "negocios"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "negocios"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prazo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prazo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoAtividade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoAtividade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "usuario"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
