/**
 * Mov.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package movimentacao.webservice;

public class Mov  implements java.io.Serializable {
    private java.lang.String autorizado;

    private movimentacao.webservice.Cliente cliente;

    private java.util.Calendar data;

    private java.lang.Integer id;

    private java.lang.String obs;

    private java.lang.String posto;

    private java.lang.String recebido;

    private java.lang.Integer talao;

    private movimentacao.webservice.Usuario usuario;

    public Mov() {
    }

    public Mov(
           java.lang.String autorizado,
           movimentacao.webservice.Cliente cliente,
           java.util.Calendar data,
           java.lang.Integer id,
           java.lang.String obs,
           java.lang.String posto,
           java.lang.String recebido,
           java.lang.Integer talao,
           movimentacao.webservice.Usuario usuario) {
           this.autorizado = autorizado;
           this.cliente = cliente;
           this.data = data;
           this.id = id;
           this.obs = obs;
           this.posto = posto;
           this.recebido = recebido;
           this.talao = talao;
           this.usuario = usuario;
    }


    /**
     * Gets the autorizado value for this Mov.
     * 
     * @return autorizado
     */
    public java.lang.String getAutorizado() {
        return autorizado;
    }


    /**
     * Sets the autorizado value for this Mov.
     * 
     * @param autorizado
     */
    public void setAutorizado(java.lang.String autorizado) {
        this.autorizado = autorizado;
    }


    /**
     * Gets the cliente value for this Mov.
     * 
     * @return cliente
     */
    public movimentacao.webservice.Cliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this Mov.
     * 
     * @param cliente
     */
    public void setCliente(movimentacao.webservice.Cliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the data value for this Mov.
     * 
     * @return data
     */
    public java.util.Calendar getData() {
        return data;
    }


    /**
     * Sets the data value for this Mov.
     * 
     * @param data
     */
    public void setData(java.util.Calendar data) {
        this.data = data;
    }


    /**
     * Gets the id value for this Mov.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Mov.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the obs value for this Mov.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this Mov.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the posto value for this Mov.
     * 
     * @return posto
     */
    public java.lang.String getPosto() {
        return posto;
    }


    /**
     * Sets the posto value for this Mov.
     * 
     * @param posto
     */
    public void setPosto(java.lang.String posto) {
        this.posto = posto;
    }


    /**
     * Gets the recebido value for this Mov.
     * 
     * @return recebido
     */
    public java.lang.String getRecebido() {
        return recebido;
    }


    /**
     * Sets the recebido value for this Mov.
     * 
     * @param recebido
     */
    public void setRecebido(java.lang.String recebido) {
        this.recebido = recebido;
    }


    /**
     * Gets the talao value for this Mov.
     * 
     * @return talao
     */
    public java.lang.Integer getTalao() {
        return talao;
    }


    /**
     * Sets the talao value for this Mov.
     * 
     * @param talao
     */
    public void setTalao(java.lang.Integer talao) {
        this.talao = talao;
    }


    /**
     * Gets the usuario value for this Mov.
     * 
     * @return usuario
     */
    public movimentacao.webservice.Usuario getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this Mov.
     * 
     * @param usuario
     */
    public void setUsuario(movimentacao.webservice.Usuario usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mov)) return false;
        Mov other = (Mov) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.autorizado==null && other.getAutorizado()==null) || 
             (this.autorizado!=null &&
              this.autorizado.equals(other.getAutorizado()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.posto==null && other.getPosto()==null) || 
             (this.posto!=null &&
              this.posto.equals(other.getPosto()))) &&
            ((this.recebido==null && other.getRecebido()==null) || 
             (this.recebido!=null &&
              this.recebido.equals(other.getRecebido()))) &&
            ((this.talao==null && other.getTalao()==null) || 
             (this.talao!=null &&
              this.talao.equals(other.getTalao()))) &&
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
        if (getAutorizado() != null) {
            _hashCode += getAutorizado().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
        }
        if (getPosto() != null) {
            _hashCode += getPosto().hashCode();
        }
        if (getRecebido() != null) {
            _hashCode += getRecebido().hashCode();
        }
        if (getTalao() != null) {
            _hashCode += getTalao().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Mov.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "mov"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("autorizado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "autorizado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "cliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("obs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "obs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recebido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recebido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("talao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "talao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
