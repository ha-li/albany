package com.gecko.core.repository;

import core.application.UnitOfWork;
import bacs.domain.Transaction;
import core.repository.JpaRepository;
import org.junit.Test;

import java.math.BigDecimal;

public class JpaRepositoryTest {

   @Test
   public void test_list () {

      int count = 2;

      for (int i = 0; i < count; i++) {
         try (UnitOfWork uow = UnitOfWork.beginUnitOfWork ()) {
            Transaction transaction = new Transaction ();
            transaction.setAccountName("Test1");
            transaction.setAmount(BigDecimal.ONE);
            transaction.setBankAccountNumber("123123");
            //transaction.setPaymentMethod(1);
            transaction.setRtiHash("hast");
            transaction.setSortNumber("234");

            JpaRepository.save (transaction);
            UnitOfWork.commitUnitOfWork ();
         }
      }

   }
}
