import requests
from typing import Dict, Any

class WebServiceEmployeeService:
    def __init__(self):
        # Using JSONPlaceholder as a mock API
        self.base_url = "https://jsonplaceholder.typicode.com"
    
    def fetch_employee(self, employee_code: str) -> Dict[str, Any]:
        """
        Fetches employee information from the REST API
        
        Args:
            employee_code: String code/ID of the employee
            
        Returns:
            Dict containing employee information
        """
        try:
            response = requests.get(f"{self.base_url}/users/{employee_code}")
            response.raise_for_status()
            
            data = response.json()
            # Transform the API response to match our expected format
            return {
                'id': data['id'],
                'first_name': data['name'].split()[0],
                'last_name': data['name'].split()[-1],
                'email': data['email'],
                'position': data.get('company', {}).get('bs', 'Not specified')
            }
            
        except requests.RequestException as e:
            print(f"Error fetching from API: {e}")
            raise 