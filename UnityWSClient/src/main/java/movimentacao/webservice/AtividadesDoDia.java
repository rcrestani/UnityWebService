/**
 * AtividadesDoDia.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package movimentacao.webservice;

public class AtividadesDoDia  implements java.io.Serializable {
    private java.lang.String acao;

    private java.lang.String cliente;

    private java.lang.String obs;

    private java.util.Date prazo;

    private movimentacao.webservice.UsuarioWS usuario;

    private float valor;

    public AtividadesDoDia() {
    }

    public AtividadesDoDia(
           java.lang.String acao,
           java.lang.String cliente,
           java.lang.String obs,
           java.util.Date prazo,
           movimentacao.webservice.UsuarioWS usuario,
           float valor) {
           this.acao = acao;
           this.cliente = cliente;
           this.obs = obs;
           this.prazo = prazo;
           this.usuario = usuario;
           this.valor = valor;
    }


    /**
     * Gets the acao value for this AtividadesDoDia.
     * 
     * @return acao
     */
    public java.lang.String getAcao() {
        return acao;
    }


    /**
     * Sets the acao value for this AtividadesDoDia.
     * 
     * @param acao
     */
    public void setAcao(java.lang.String acao) {
        this.acao = acao;
    }


    /**
     * Gets the cliente value for this AtividadesDoDia.
     * 
     * @return cliente
     */
    public java.lang.String getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this AtividadesDoDia.
     * 
     * @param cliente
     */
    public void setCliente(java.lang.String cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the obs value for this AtividadesDoDia.
     * 
     * @return obs
     */
    public java.lang.String getObs() {
        return obs;
    }


    /**
     * Sets the obs value for this AtividadesDoDia.
     * 
     * @param obs
     */
    public void setObs(java.lang.String obs) {
        this.obs = obs;
    }


    /**
     * Gets the prazo value for this AtividadesDoDia.
     * 
     * @return prazo
     */
    public java.util.Date getPrazo() {
        return prazo;
    }


    /**
     * Sets the prazo value for this AtividadesDoDia.
     * 
     * @param prazo
     */
    public void setPrazo(java.util.Date prazo) {
        this.prazo = prazo;
    }


    /**
     * Gets the usuario value for this AtividadesDoDia.
     * 
     * @return usuario
     */
    public movimentacao.webservice.UsuarioWS getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this AtividadesDoDia.
     * 
     * @param usuario
     */
    public void setUsuario(movimentacao.webservice.UsuarioWS usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the valor value for this AtividadesDoDia.
     * 
     * @return valor
     */
    public float getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this AtividadesDoDia.
     * 
     * @param valor
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AtividadesDoDia)) return false;
        AtividadesDoDia other = (AtividadesDoDia) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.acao==null && other.getAcao()==null) || 
             (this.acao!=null &&
              this.acao.equals(other.getAcao()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.obs==null && other.getObs()==null) || 
             (this.obs!=null &&
              this.obs.equals(other.getObs()))) &&
            ((this.prazo==null && other.getPrazo()==null) || 
             (this.prazo!=null &&
              this.prazo.equals(other.getPrazo()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            this.valor == other.getValor();
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
        if (getAcao() != null) {
            _hashCode += getAcao().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getObs() != null) {
            _hashCode += getObs().hashCode();
        }
        if (getPrazo() != null) {
            _hashCode += getPrazo().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        _hashCode += new Float(getValor()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AtividadesDoDia.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "atividadesDoDia"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "acao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservice.movimentacao/", "usuarioWS"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
