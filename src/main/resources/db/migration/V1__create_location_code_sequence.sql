-- V1__add_auto_codes.sql

-- 1. Product: INTERNAL_CODE (INT01, INT02...)
CREATE SEQUENCE IF NOT EXISTS internal_code_seq START 1 INCREMENT 1;
ALTER TABLE products
    ALTER COLUMN internal_code SET DEFAULT ('INT' || LPAD(nextval('internal_code_seq')::text, 3, '0'));

-- 2. Production-Order: ORDER_CODE (ORD01, ORD02...)
CREATE SEQUENCE IF NOT EXISTS order_code_seq START 1 INCREMENT 1;
ALTER TABLE production_orders
    ALTER COLUMN order_code SET DEFAULT ('ORD' || LPAD(nextval('order_code_seq')::text, 3, '0'));

-- 3. Detail-Dispatch: DISPATCH_CODE (DSP01, DSP02...)
CREATE SEQUENCE IF NOT EXISTS dispatch_code_seq START 1 INCREMENT 1;
ALTER TABLE detail_dispatch
    ALTER COLUMN dispatch_code SET DEFAULT ('DSP' || LPAD(nextval('dispatch_code_seq')::text, 3, '0'));

-- 4. Batch: BATCH_CODE (BTC01, BTC02...)
CREATE SEQUENCE IF NOT EXISTS batch_code_seq START 1 INCREMENT 1;
ALTER TABLE batchs
    ALTER COLUMN batch_code SET DEFAULT ('BTC' || LPAD(nextval('batch_code_seq')::text, 3, '0'));

-- 5. Replacement-Claim: CLAIM_CODE (CLM01, CLM02...)
CREATE SEQUENCE IF NOT EXISTS claim_code_seq START 1 INCREMENT 1;
ALTER TABLE replacement_claims
    ALTER COLUMN claim_code SET DEFAULT ('CLM' || LPAD(nextval('claim_code_seq')::text, 3, '0'));

-- 6. Locations (LCT01, LCT02...)
CREATE SEQUENCE IF NOT EXISTS location_code_seq START 1 INCREMENT 1;
ALTER TABLE locations
    ALTER COLUMN location_code SET DEFAULT ('LCT' || LPAD(nextval('location_code_seq')::text, 3, '0'));