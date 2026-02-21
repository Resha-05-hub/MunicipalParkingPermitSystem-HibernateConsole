package com.kce.app;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

import com.kce.bean.PermitHolder;
import com.kce.bean.ParkingPermit;
import com.kce.service.ParkingService;
import com.kce.util.ValidationException;

public class ParkingMain {

    private static ParkingService service = new ParkingService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Municipal Parking Permit System (Hibernate) ===");

        try {

            // ===== REGISTER HOLDER =====
            PermitHolder holder = new PermitHolder();

            System.out.print("Enter Permit Holder ID: ");
            holder.setPermitHolderID(sc.nextLine());

            System.out.print("Enter Full Name: ");
            holder.setFullName(sc.nextLine());

            System.out.print("Enter Holder Type (RESIDENT/VISITOR): ");
            holder.setHolderType(sc.nextLine());

            System.out.print("Enter Address Line 1: ");
            holder.setAddressLine1(sc.nextLine());

            System.out.print("Enter Address Line 2: ");
            holder.setAddressLine2(sc.nextLine());

            System.out.print("Enter Ward Code: ");
            holder.setWardCode(sc.nextLine());

            System.out.print("Enter Mobile Number: ");
            holder.setMobile(sc.nextLine());

            System.out.print("Enter Email: ");
            holder.setEmail(sc.nextLine());

            holder.setStatus("ACTIVE");

            service.registerNewPermitHolder(holder);

            // ===== FETCH HOLDER =====
            PermitHolder existingHolder =
                    service.viewPermitHolderDetails(holder.getPermitHolderID());

            // ===== CREATE PERMIT =====
            ParkingPermit permit = new ParkingPermit();

            System.out.print("Enter Permit ID: ");
            permit.setPermitID(sc.nextLine());

            permit.setPermitHolder(existingHolder);

            System.out.print("Enter Vehicle Registration No: ");
            permit.setVehicleRegNo(sc.nextLine());

            System.out.print("Enter Vehicle Type (CAR/BIKE): ");
            permit.setVehicleType(sc.nextLine());

            System.out.print("Enter Zone Code: ");
            permit.setZoneCode(sc.nextLine());

            Date start = new Date(System.currentTimeMillis());
            Date end = new Date(System.currentTimeMillis()
                    + 180L * 24 * 60 * 60 * 1000);

            permit.setPermitStartDate(start);
            permit.setPermitEndDate(end);
            permit.setPermitStatus("ACTIVE");
            permit.setViolationCount(0);
            permit.setOutstandingFineAmount(BigDecimal.ZERO);

            service.applyForNewPermit(permit);

            System.out.println("SUCCESSFULLY EXECUTED");

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}