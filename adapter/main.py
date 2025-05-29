from adapter.employee_adapter import EmployeeAdapter

def main():
    # Create the adapter
    employee_adapter = EmployeeAdapter()
    
    try:
        # Example: Get employee from database (using ID)
        print("Fetching employee from database...")
        db_employee = employee_adapter.get_employee(1)
        print(f"Database employee: {db_employee}\n")
        
        # Example: Get employee from web service (using string ID)
        print("Fetching employee from web service...")
        web_employee = employee_adapter.get_employee("2")
        print(f"Web service employee: {web_employee}")
        
    except Exception as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    main() 