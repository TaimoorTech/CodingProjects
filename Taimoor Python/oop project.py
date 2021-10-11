class electronic_device:
    computer=5
    mobile=4

class pocket_device(electronic_device):
    pocket_mobiles=7
    pocket_computer=8

class phone(pocket_device):
    motorolla=15
    samsung=11

electronic=electronic_device()
pocket=pocket_device()
phones=phone()


print(phones.mobile)
