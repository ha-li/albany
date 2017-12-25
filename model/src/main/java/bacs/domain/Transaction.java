package bacs.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity (name="BACS_TRANSACTION")
//@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.DynamicInsert
public class Transaction extends Identity implements Serializable {

   private static final long serialVersionUID = -6002635518885479349L;

   @Column (name="AMOUNT")
   private BigDecimal amount;

   @Column (name="BANK_ACCOUNT_NUM")
   private String bankAccountNumber;

   @Column (name="ACCOUNT_NAME")
   private String accountName;

   @Column (name="PAYMENT_METHOD")
   private short paymentMethod;

   @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
   @Column (name="REMITTANCE_DATE")
   private LocalDate remittanceDate;

   @Column (name="RTI_HASH")
   private String rtiHash;

   @Column (name="SORT_NUMBER")
   private String sortNumber;

   @Column (name="OUTBOUND_BANK_ID")
   private String outboundBankId;

   public String getOutboundBankId() {
      return outboundBankId;
   }

   public void setOutboundBankId(String outboundBankId) {
      this.outboundBankId = outboundBankId;
   }

   public BigDecimal getAmount() {
      return amount;
   }

   public void setAmount(BigDecimal amount) {
      this.amount = amount;
   }

   public String getBankAccountNumber() {
      return bankAccountNumber;
   }

   public void setBankAccountNumber(String bankAccountNumber) {
      this.bankAccountNumber = bankAccountNumber;
   }

   public String getAccountName() {
      return accountName;
   }

   public void setAccountName(String accountName) {
      this.accountName = accountName;
   }

   public short getPaymentMethod() {
      return paymentMethod;
   }

   public void setPaymentMethod(short paymentMethod) {
      this.paymentMethod = paymentMethod;
   }

   public LocalDate getRemittanceDate() {
      return remittanceDate;
   }

   public void setRemittanceDate(LocalDate remittanceDate) {
      this.remittanceDate = remittanceDate;
   }

   public String getRtiHash() {
      return rtiHash;
   }

   public void setRtiHash(String rtiHash) {
      this.rtiHash = rtiHash;
   }


   public String getSortNumber() {
      return sortNumber;
   }

   public void setSortNumber(String sortNumber) {
      this.sortNumber = sortNumber;
   }

   //@Temporal (TemporalType.TIMESTAMP)
   //@Column(name="MODIFIED_DATE")
   //@org.hibernate.annotations.UpdateTimestamp
   //private Date modifiedDate;

   //@Temporal (TemporalType.TIMESTAMP)
   //@Column(name="CREATED_DATE")
   //@org.hibernate.annotations.CreationTimestamp
   //private Date createdDate;

   //@Version
   // private short version;

   /* public String getText () {
      return text;
   }

   public void setText (String text) {
      this.text = text;
   }

   public Date getModifiedDate () {
      return modifiedDate;
   }

   public void setModifiedDate (Date modifiedDate) {
      this.modifiedDate = modifiedDate;
   }

   public Date getCreatedDate () {
      return createdDate;
   }

   public void setCreatedDate (Date createdDate) {
      this.createdDate = createdDate;
   }

   public BigDecimal getAmount () {
      return amount;
   }

   public void setAmount (BigDecimal amount) {
      this.amount = amount;
   }

   public Item getItem () {
      return item;
   }

   public void setItem (Item item) {
      this.item = item;
   }

   public short getVersion () {
      return version;
   }


   @Override
   public int hashCode () {
      return getText().hashCode () + getAmount().hashCode () + getItem().hashCode ();
   }

   @Override
   public boolean equals (Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;

      return false;
   } */
}
