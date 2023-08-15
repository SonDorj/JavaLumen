# Grocery Shop Application

### Domain Folder: Acme
#### Deployable War is in Deploy Folder

## :shopping_cart: Domain: Grocery Shop

### :apple: Entities:

#### :bread: Entity: Grocery
- **Attributes:**
  - groceryId (Primary Key)
  - name
  - price
  - stock

#### :bust_in_silhouette: Entity: User
- **Attributes:**
  - userId (Primary Key)
  - username (Unique)
  - password
  - type

## :triangular_ruler: Architecture:

### :computer: Presentation Tier (User Interface):
- Controllers and Java JSPs

### :briefcase: Business Logic Tier:
- Services and Exceptions

### :floppy_disk: Data Tier:
- DAO and Utils

### :chart_with_upwards_trend: Model:
- Grocery, User

## :link: Dependencies:

- `mysql-connector-j-8.1.0`
- `taglibs-standard-impl-1.2.5`
- `taglibs-standard-spec-1.2.5`

## :wrench: Configurations:

- Database: `acme`
- User: `root`
- Password: `admin@123`

## :computer_mouse: Usage:

### :white_check_mark: Admin Privilege:
- **Username:** `Admin`
- **Password:** `Admin@123`
- **Actions:**
  - Add User
  - Delete User
  - Update Grocery
  - Delete Grocery
  - Add Grocery
  - Search Grocery (By Name)

### :white_check_mark: User Privilege:
- **Actions:**
  - Add Item to Cart
  - Buy Items from Cart

### Run populate in util to populate the inventory
