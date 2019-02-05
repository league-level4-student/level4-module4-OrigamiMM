package _04_hospital;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/* requirements:
 * 1. hospital has doctors and patients
 * 2. doctors can be GeneralPractictioner or Surgeon
 * 3. patients can be assigned to doctors
 * 4. doctors can have no more than 3 patients
 */

class DoctorFullException extends Exception {
	
	void terminate() {
		System.exit(0);
	}
	
}

class Hospital {
	ArrayList<Doctor> docs = new ArrayList<Doctor>();
	ArrayList<Patient> pats = new ArrayList<Patient>();
	
	public void addDoctor(Doctor d) {
		docs.add(d);
	}
	public void addPatient(Patient p) {
		pats.add(p);
	}
	
	public ArrayList<Doctor> getDoctors() {
		return docs;
	}
	public ArrayList<Patient> getPatients(){
		return pats;
	}
	public void assignPatientsToDoctors() {
		int s = 0;
		for (Doctor doctor : docs) {
			for (int i = s; i < pats.size(); i++) {
				try {
					doctor.assignPatient(pats.get(i));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		s += 3;
		}
	}
} 

class Doctor {
	ArrayList<Patient> list = new ArrayList<Patient>();
	
	public void doMedicine() {
		for (Patient patient : list) {
			patient.setCare(true);
		}
	}
	
	public void assignPatient(Patient p) throws Exception{
		if(list.size() <3) {
			list.add(p);
		}else {
			throw new DoctorFullException();
		}
		
	}
	
	public ArrayList<Patient> getPatients(){
		return list;
	}
	
	public boolean performsSurgery() {
		return false;
	}
	public boolean makesHouseCalls() {
		return false;
	}
}

class GeneralPractitioner extends Doctor {
	public boolean makesHouseCalls() {
		return true;
	}
}

class Surgeon extends Doctor{
	public boolean performsSurgery() {
		return true;
	}
}

class Patient {
	private boolean caredFor = false;
	
	public void setCare(boolean t) {
		caredFor = t;
	}
	
	public boolean feelsCaredFor() {
		return caredFor;
	}
	public void checkPulse() {
		caredFor = true;
	}
}


public class HospitalTest extends TestCase {

	Hospital testHospital = new Hospital();

	public void testAddDoctor() {
		testHospital.addDoctor(new GeneralPractitioner());
		testHospital.addDoctor(new GeneralPractitioner());
		testHospital.addDoctor(new Surgeon());
		assertEquals(3, testHospital.getDoctors().size());
	}

	public void testAddPatient() throws Exception {
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		testHospital.addPatient(new Patient());
		assertEquals(3, testHospital.getPatients().size());
	}

	/* Fix asserts one at a time */
	public void testDoctorsHaveSpecialties() throws Exception {
		Doctor testDoctor = new Doctor();
		assertEquals(false, testDoctor.performsSurgery());

		Doctor testSurgeon = new Surgeon();
		assertEquals(true, testSurgeon.performsSurgery());

		GeneralPractitioner testGP = new GeneralPractitioner();
		assertEquals(true, testGP.makesHouseCalls());
		assertEquals(false, testSurgeon.makesHouseCalls());
		assertEquals(false, testDoctor.makesHouseCalls());
	}

	/* A doctor has a list of patients */
	public void testAssignDoctor() throws Exception {
		Doctor testDoctor = new GeneralPractitioner();
		testDoctor.assignPatient(new Patient());
		assertEquals(1, testDoctor.getPatients().size());
		testDoctor.assignPatient(new Patient());
		assertEquals(2, testDoctor.getPatients().size());
		testDoctor.assignPatient(new Patient());
		assertEquals(3, testDoctor.getPatients().size());
	}

	/* When you check a patient's pulse, they feel cared for */
	public void testCheckPulse() throws Exception {
		Patient testPatient = new Patient();
		assertEquals(false, testPatient.feelsCaredFor());
		testPatient.checkPulse();
		assertEquals(true, testPatient.feelsCaredFor());
	}

	/* Doctors work on their Patients by checking their pulses. */
	public void testDoctorsWork() throws Exception {
		Doctor testDoctor = new GeneralPractitioner();
		Patient max = new Patient();
		Patient macky = new Patient();
		testDoctor.assignPatient(max);
		testDoctor.assignPatient(macky);
		assertEquals(false, max.feelsCaredFor());
		assertEquals(false, macky.feelsCaredFor());
		testDoctor.doMedicine();
		assertEquals(true, max.feelsCaredFor());
		assertEquals(true, macky.feelsCaredFor());
	}

	/* test calling assignPatient when doctor is full throws exception */
	public void testDoctorsCanOnlyHandle3Patients() throws Exception {
		Doctor testDoctor = new Doctor();
		testDoctor.assignPatient(new Patient());
		testDoctor.assignPatient(new Patient());
		testDoctor.assignPatient(new Patient());
		try {
			testDoctor.assignPatient(new Patient());
			assertTrue(false);
		} catch (DoctorFullException dfe) {
			assertTrue(true);
		}
assertTrue(testDoctor.getPatients().size() == 3);
	}

	public void test8Patients() throws Exception {
		// TODO: add 3 doctors to hospital
		for(int i = 0; i < 3; i++) {
			testHospital.addDoctor(new Doctor());
		}
		// TODO: add 8 patients to hospital
		for(int i = 0; i < 8; i++) {
			testHospital.addPatient(new Patient());
		}
		// hospital assigns patients to doctors
		testHospital.assignPatientsToDoctors();
		// hospital.getDoctors shows doctors have 3, 3, 2 patients
		List<Doctor> testDoctors = testHospital.getDoctors();
		assertEquals(3, testDoctors.get(0).getPatients().size());
		assertEquals(3, testDoctors.get(1).getPatients().size());
		assertEquals(2, testDoctors.get(2).getPatients().size());
	}



}
