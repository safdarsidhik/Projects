#Hide secret message in Image using python

#pip install stegano 

from stegano import lsb

secret = lsb.hide('cmypic.png', 'Congrats! Happy hacking!')
secret.save('secret_image.png')
print(lsb.reveal('secret_image.png')) 
