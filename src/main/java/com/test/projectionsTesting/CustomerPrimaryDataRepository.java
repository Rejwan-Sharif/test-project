//package com.test.projectionsTesting;
//
//import com.test.textFileUpload.CardAccountBasicInfoEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//
//@Repository
//public interface CustomerPrimaryDataRepository extends JpaRepository<CardAccountBasicInfoEntity, Long> {
//
//    @Query(value = "SELECT CABI.ACCOUNT_NO AS accountNo, " +
//            "CABI.CARD_NO AS cardNo, " +
//            "CABI.CLIENT_ID AS clientId, " +
//            "CABI.CONTRACT_ID AS contractId, " +
//            "CABI.CUSTOMER_NAME AS customerName, " +
//            "CABI.C_CITY AS city " +
//            "FROM CRAD_ACCOUNT_BASIC_INFO CABI " +
//            "WHERE (:account IS NULL OR CABI.ACCOUNT_NO = :account) " +
//            "AND (:card IS NULL OR CABI.CARD_NO = :card)",
//            nativeQuery = true)
//    List<AccountBasicInfoProjection>findAccountPrimaryData(@Param("account") String account,
//                                                           @Param("card") String card);
//}
